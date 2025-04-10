package com.gasigwatin.Content.Calendar.Springboot.project.model;

//1. The first step is to create a model package
//2. Second step is to create a Record

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
