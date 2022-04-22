package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysDepartEntity;
import io.renren.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysDepartDao extends BaseMapper<SysDepartEntity> {

  void deletRoleByDepartId(@Param("id") Long id);



}
