package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.netty.util.internal.StringUtil;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.dao.SysDepartDao;
import io.renren.modules.sys.dao.SysRoleDao;
import io.renren.modules.sys.entity.SysDepartEntity;
import io.renren.modules.sys.entity.SysRoleEntity;
import io.renren.modules.sys.service.SysDepartService;
import io.renren.modules.sys.vo.DepartRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysDepartServiceImpl extends ServiceImpl<SysDepartDao, SysDepartEntity> implements SysDepartService {
  @Autowired
  SysDepartDao sysDepartDao;
  @Autowired
  SysRoleDao sysRoleDao;

  /**
   * @param params
   * @return
   */
  @Override
  public PageUtils queryPage(Map<String, Object> params) {
    List<SysDepartEntity> result = new ArrayList<>();
    //params是查询条件
    String status = params.get("status").toString();
    String departName = params.get("departName").toString();

    int currPage = Integer.parseInt(params.get("currPage").toString());
    int pageSize = Integer.parseInt(params.get("pageSize").toString());
    //先从depart获取departs
    List<SysDepartEntity> departs = this.baseMapper.selectList(new QueryWrapper<SysDepartEntity>()
            .eq(!StringUtil.isNullOrEmpty(departName), "depart_name", departName)
            .eq(!StringUtil.isNullOrEmpty(status), "status", params.get("status")));
    for (SysDepartEntity s : departs) {
      List<SysRoleEntity> roles = sysRoleDao.getRoleByDepartId(s.getDepartId());
      s.setSysRole(roles);
      result.add(s);
    }
    return new PageUtils(result, result.size(), pageSize, currPage);

  }

  @Override
  public Boolean saveDepart(SysDepartEntity depart, List<Long> roleIds) {
    long uuid = Math.abs(UUID.randomUUID().getMostSignificantBits());
    depart.setCreateTime(new Date());
    depart.setUpdateTime(new Date());
    //是否已存在相同部门
    Long departId = sysDepartDao.isSameDepart(depart.getDepartName());
    if (departId != null) {
      return false;
    }
//    //添加分行支行的时候 查询是否已存在角色
//    Integer num=sysDepartDao.queryIsExsit(departId,roleId);
//    if(num!=0){
//      //返回错误
//      return false;
//    }
    depart.setDepartId(uuid);
    this.baseMapper.insert(depart);
    for (Long roleId : roleIds) {
      sysDepartDao.saveDepartAndRole(uuid, roleId);
    }
    return true;
  }

  //在更新和删除的时候考虑 部门 角色 人员
  @Override
  public void update(SysDepartEntity depart, List<Long> roleIds) {
    this.updateById(depart);
    // 先删除 后更
    sysDepartDao.deletRole(depart.getDepartId());

    for (Long roleId : roleIds) {
      sysDepartDao.saveDepartAndRole(depart.getDepartId(), roleId);

    }

  }


  @Override
  public void deleteEnhance(DepartRoleVo param) {
    //删除角色
    if (param.getRoleId().size() != 0) {
      List<Long> list = param.getRoleId();
      for (Long roleId : list) {
        sysDepartDao.deletRoleByDepartId(param.getDepartId(), roleId);

      }
    }
    this.removeById(param.getId());
  }


}
