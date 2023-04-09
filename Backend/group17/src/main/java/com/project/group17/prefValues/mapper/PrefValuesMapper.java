package com.project.group17.prefValues.mapper;

import com.project.group17.prefNames.entity.PrefNamesEntity;
import com.project.group17.prefOptions.entity.PrefOptionsEntity;
import com.project.group17.prefValues.entity.PrefValuesEntity;
import com.project.group17.prefValues.model.PrefValueSaveReq;
import com.project.group17.user.entity.User;
import org.springframework.util.ObjectUtils;

public class PrefValuesMapper {

    public static PrefValuesEntity saveReqToEntityMapper(PrefValueSaveReq prefValueSaveReq, int userId) {
        PrefValuesEntity prefValuesEntity = new PrefValuesEntity();
        User user = new User();
        user.setId(userId);
        prefValuesEntity.setUser(user);

        PrefNamesEntity prefNames = new PrefNamesEntity();
        prefNames.setPrefId(prefValueSaveReq.getPrefNameId());
        prefValuesEntity.setPrefName(prefNames);
        if (prefValueSaveReq.getPrefOptionId() != null) {
            PrefOptionsEntity prefOptions = new PrefOptionsEntity();
            prefOptions.setPrefId(prefValueSaveReq.getPrefOptionId());
            prefValuesEntity.setPrefOption(prefOptions);
        }

        return prefValuesEntity;
    }

    public static PrefValueSaveReq entityToGetPrefCRes(PrefValuesEntity prefValuesEntity) {
        PrefValueSaveReq prefValueSaveReq = new PrefValueSaveReq();
        prefValueSaveReq.setPrefNameId(prefValuesEntity.getPrefName().getPrefId());
        if (ObjectUtils.isEmpty(prefValuesEntity.getPrefOption()) || prefValuesEntity.getPrefOption().getPrefId() == null) {
            prefValueSaveReq.setPrefOptionId(null);
        } else {
            prefValueSaveReq.setPrefOptionId(prefValuesEntity.getPrefOption().getPrefId());
        }
        return prefValueSaveReq;
    }
}
