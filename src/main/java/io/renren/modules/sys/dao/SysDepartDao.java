package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysDepartEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysDepartDao extends BaseMapper<SysDepartEntity> {

  void deletRoleByDepartId(@Param("id") Long id,@Param("roleId") Long roleId);
  void deletRole(@Param("id") Long id);

  Integer queryIsExsit(@Param("departId") long departId, @Param("roleId") long roleId);

  void saveDepartAndRole(@Param("departId") long departId, @Param("roleId") Long roleIds);
  void updateDepartAndRole(@Param("departId") long departId, @Param("roleId") Long roleIds);

  Long isSameDepart(@Param("name") String name,@Param("distinguishing") String distinguishing);

}
