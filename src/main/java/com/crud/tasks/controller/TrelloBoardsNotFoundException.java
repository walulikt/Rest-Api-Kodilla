package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;

import java.util.ArrayList;

public class TrelloBoardsNotFoundException extends Exception {

    ArrayList<TrelloBoardDto> emptyList = new ArrayList<>();
}
