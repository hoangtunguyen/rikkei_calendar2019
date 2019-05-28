package com.example.RikkeiCalendar.convert;

import com.example.RikkeiCalendar.entity.CategoryTypeEntity;
import com.example.RikkeiCalendar.entity.RepeatCatetoryEntity;
import com.example.RikkeiCalendar.respones.RepeatCategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class RepeatCategoryConvert {
    public static RepeatCategoryResponse convert(RepeatCatetoryEntity repeatCatetoryEntity){
        RepeatCategoryResponse response=new RepeatCategoryResponse();
        List<Integer> repeatDays=new ArrayList<>();
        for (CategoryTypeEntity type:repeatCatetoryEntity.getCategoryTypeEntities()){
            repeatDays.add(type.getTypeRepeatEntity().getType_name());
        }
        response.setId(repeatCatetoryEntity.getId());

        response.setCateName(RepeatCategoryConvert.getRepeat(repeatCatetoryEntity.getCategoryName()));
        response.setFinishTime(repeatCatetoryEntity.getFinishTimeRepeat());
        response.setRepeatDays(repeatDays);
        return response;
    }
    public static String getRepeat(int value){
        switch (value){
            case 0:
                return "NONE";
            case 1:
                return "DAILY";
            case 2:
                return "WEEKLY";
            case 3:
                return "MONTHLY";
        }
        return "ERROR";
    }
}
