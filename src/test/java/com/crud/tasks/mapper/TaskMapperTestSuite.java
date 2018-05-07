package com.crud.tasks.mapper;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    /*@Test
    public void taskMapperTest (){
        //Given
        Task task = new Task(1l, "Learn Java","Every day at list 3h" );

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        Assert.assertEquals(1l,taskDto.getId().longValue());
    }
    @Test
    public void taskDtoMapperTest (){
        //Given
        TaskDto taskDto = new TaskDto(1l, "Learn Java","Every day at list 3h" );

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        Assert.assertEquals(1l,task.getId().longValue());
    }

    @Test
    public void taskListMapperTest(){
        //Given
        Task task = new Task(1l, "Learn Java","Every day at list 3h" );
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        //When
        List<TaskDto> taskDtoList = taskMapper.maToTaskDtoList(tasks);

        //Then
        Assert.assertEquals(1,taskDtoList.size());
    }*/

}
