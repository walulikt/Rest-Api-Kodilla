package com.crud.tasks.service;

import com.crud.tasks.config.ActuatorConfig;
import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private ActuatorConfig actuatorConfig;

    @Autowired
    private DbService dbService;

    @Autowired
    @Qualifier ("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail (String message){
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your Tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url","http://localhost:8080/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("company_name", actuatorConfig.getCompanyName());
        context.setVariable("show_button",false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality",functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String dailyReportTaskCard (String message){
        message = "On the end of this day you have those tasks in your Data Base";
        List<String> tasksList = new ArrayList<>();
        for (int i = 0; i<dbService.getAllTasks().size(); i++){
            tasksList.add(dbService.getAllTasks().get(i).getTitle());
        }
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("task_count", dbService);
        context.setVariable("task_title_list", tasksList);
        context.setVariable("tasks_url","http://localhost:8080/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("company_name", actuatorConfig.getCompanyName());
        context.setVariable("show_button",true);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);

        return templateEngine.process("mail/daily-report-tasks-avaible-mail", context);
    }
}
