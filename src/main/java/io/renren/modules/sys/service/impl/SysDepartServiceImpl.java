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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    String departName =params.get("departName").toString();

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
  public void saveDepart(SysDepartEntity depart) {
    depart.setCreateTime(new Date());
    depart.setUpdateTime(new Date());
    //depart.setStatus(0);
    this.saveOrUpdate(depart);
//    this.save(depart);
  }

  //在更新和删除的时候考虑 部门 角色 人员
  @Override
  public void update(SysDepartEntity depart) {
    this.updateById(depart);
    //修改标识的时候改user的标识


  }

  @Override
  public void deleteEnhance(Long departId) {
    //删除 部门下有角色
    sysDepartDao.deletRoleByDepartId(departId);

    this.removeById(departId);
  }


}
