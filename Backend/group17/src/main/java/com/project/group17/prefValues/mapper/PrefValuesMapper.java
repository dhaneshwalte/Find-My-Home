package com.project.group17.prefValues.mapper;

import com.project.group17.prefNames.entity.PrefNamesEntity;
import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import com.project.group17.prefValues.entity.PrefValuesEntity;
import com.project.group17.prefValues.model.PrefValueSaveReq;
import com.project.group17.user.entity.User;

public class PrefValuesMapper {

    public static PrefValuesEntity saveReqToEntityMapper(PrefValueSaveReq prefValueSaveReq, int userId){
        PrefValuesEntity prefValuesEntity = new PrefValuesEntity();
        User user = new User();
        user.setId(userId);
        prefValuesEntity.setUser(user);

        PrefNamesEntity prefNames = new PrefNamesEntity();
        prefNames.setPrefId(prefValueSaveReq.getPrefNameId());
        prefValuesEntity.setPrefName(prefNames);

        PrefOptionsEntity prefOptions = new PrefOptionsEntity();
        prefOptions.setPrefId(prefValueSaveReq.getPrefOptionId());
        prefValuesEntity.setPrefOption(prefOptions);

        return prefValuesEntity;
    }
}
