package com.example.RikkeiCalendar.convert;

import com.example.RikkeiCalendar.entity.RepeatCatetoryEntity;
import com.example.RikkeiCalendar.respones.RepeatCategoryResponse;

public class RepeatCategoryConvert {
    public static RepeatCategoryResponse convert(RepeatCatetoryEntity repeatCatetoryEntity){
        RepeatCategoryResponse response=new RepeatCategoryResponse();
        response.setId(repeatCatetoryEntity.getId());
        response.setCateName(repeatCatetoryEntity.getCategoryName().name());
        response.setFinishTime(repeatCatetoryEntity.getFinishTimeRepeat());
        return response;
    }
}
