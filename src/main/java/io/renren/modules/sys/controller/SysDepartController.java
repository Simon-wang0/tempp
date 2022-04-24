package io.renren.modules.sys.controller;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysDepartEntity;
import io.renren.modules.sys.service.SysDepartService;
import io.renren.modules.sys.vo.DepartRoleVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/depart")
public class SysDepartController extends AbstractController {
  @Autowired
  SysDepartService sysDepartService;


  @GetMapping("/test")
  public String test() {
    return "ok";
  }

  /**
   * 列表
   */
  @GetMapping("/list")
  @RequiresPermissions("sys:depart:list")
  public R list(@RequestParam Map<String, Object> params) {
    PageUtils page = sysDepartService.queryPage(params);
    return R.ok().put("page", page);
  }

  /**
   * 保存
   */


  @PostMapping("/save")
  @RequiresPermissions("sys:depart:save")
  public R save(@RequestBody SysDepartEntity depart) {
    List<Long> roleIds = depart.getRoleId();
      Boolean flag = sysDepartService.saveDepart(depart, roleIds);
      if (flag == false) {
        return R.error("该部门下已存在，或者角色重复");
      }
    return R.ok();
  }

  /**
   * 修改
   */

  @PostMapping("/update")
  @RequiresPermissions("sys:depart:update")
  public R update(@RequestBody SysDepartEntity depart) {
    List<Long> roleIds = depart.getRoleId();
    //修改部门 和角色
      sysDepartService.update(depart, roleIds);

    return R.ok();
  }


  /**
   * 增强删除
   */
  @SysLog("增强删除")
  @PostMapping("/deleteEnhance")
  @RequiresPermissions("sys:depart:deleteEnhance")
  public R deleteEnhance(@RequestBody List<DepartRoleVo> params) {
    for (DepartRoleVo param : params) {
      sysDepartService.deleteEnhance(param);
    }

    return R.ok();
  }


}
