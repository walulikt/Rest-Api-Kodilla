package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskMapper taskMapper;
    @MockBean
    private DbService service;
    @MockBean
    private Task task;


    @Test
    public void shouldFetchEmptyList() throws Exception{
        //Given
        List<TaskDto> taskDtos=new ArrayList<>();
        List<Task> tasks=new ArrayList<>();
        when(taskMapper.maToTaskDtoList(ArgumentMatchers.anyList())).thenReturn(taskDtos);
        when(service.getAllTasks()).thenReturn(tasks);

        //When & Then
        mockMvc.perform(get("/v1/task/getTasks"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$",hasSize(0)));
    }

    @Test
    public void shouldFetchTask() throws Exception{
        //Given
        TaskDto taskDto = new TaskDto(1l, "Learn it!", "Learn how to test rest");
        when(taskMapper.mapToTaskDto(ArgumentMatchers.any(Task.class))).thenReturn(taskDto);
        when(service.getTask(1l)).thenReturn(Optional.of(new Task()));

        //When & Then
        mockMvc.perform(get("/v1/task/getTask").contentType(MediaType.APPLICATION_JSON)
                .param("1l"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$id",is("1")))
                .andExpect(jsonPath("$title",is("Learn it!")));
    }

    @Test
    public void shouldCreateTask() throws Exception{
        //Given
        TaskDto taskDto = new TaskDto(1l, "Learn it!", "Learn how to test rest");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(post("/v1/task/createTask").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$id",is("1")))
                .andExpect(jsonPath("$title",is("Learn it!")));
    }

    @Test
    public void shouldFetchChangedTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1l, "Learn it!", "Learn how to test rest");
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        when(service.saveTask(task)).thenReturn(new Task());

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(put("/v1/task/updateTask").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$id", is("1")))
                .andExpect(jsonPath("$title", is("Learn it!")));
    }

    @Test
    public void shouldDeleteTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1l, "Learn it!", "Learn how to test rest");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
       /* doNothing()...?*/


        //When & Then
        mockMvc.perform(delete("/v1/task/deleteTask").contentType(MediaType.APPLICATION_JSON)
                .param("1l"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",is(nullValue())));
    }
}
