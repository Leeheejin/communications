package com.example.communications.dto;

import com.example.communications.domain.users.Users;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class UsersMainResponseDto {
    private String name;
    private Integer victory;
    private Integer rank;
    private String results;
    private String signDate;

    public UsersMainResponseDto(Users entity) {
        name = entity.getName();
        victory = entity.getVictory();
        rank = entity.getRank();
        results = entity.getResults();
        signDate = toStringDateTime(entity.getSignDate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    /**
     * Java 7 버전
     */
    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}
