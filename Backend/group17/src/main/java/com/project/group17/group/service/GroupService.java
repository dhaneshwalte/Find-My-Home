package com.project.group17.group.service;
import com.project.group17.group.entity.GroupEntity;
import com.project.group17.group.repository.GroupRepository;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;
    public void saveGroup(User user1ID, User user2ID){

        List<GroupEntity> groups = groupRepository.findAll();
        if(groups.isEmpty()){
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setGroupId(1);
            groupEntity.setUser(user1ID);
            groupEntity.setTotal_groups(1);
            groupRepository.save(groupEntity);
            GroupEntity groupEntity1 = new GroupEntity();
            groupEntity1.setGroupId(1);
            groupEntity1.setUser(user2ID);
            groupEntity1.setTotal_groups(1);
            groupRepository.save(groupEntity1);
        }else{
            //else group count increases > new group is created
                GroupEntity groupEntity = new GroupEntity();
                int total_groups = groupRepository.getMaxGroupCount()+1;
                groupEntity.setGroupId(total_groups);
                groupEntity.setUser(user1ID);
                groupEntity.setTotal_groups(total_groups);
                groupRepository.save(groupEntity);
                GroupEntity groupEntity1 = new GroupEntity();
                groupEntity1.setGroupId(total_groups);
                groupEntity1.setUser(user2ID);
                groupEntity1.setTotal_groups(total_groups);
                groupRepository.save(groupEntity1);

        }
    }
}