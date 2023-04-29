package com.example.springbootandswagger.dto.modelsRequest;

import lombok.Data;

@Data
public class GroupRequest {

    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
}
