package com.forge.strife.mapper;

import com.forge.strife.model.Task;
import com.forge.strife.to.TaskRecordGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper TASK_MAPPER = Mappers.getMapper(TaskMapper.class);

    Task recordToEntity(TaskRecordGroup.TaskRequest taskRequest);

}
