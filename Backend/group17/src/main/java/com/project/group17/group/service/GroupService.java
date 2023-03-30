package com.project.group17.group.service;
import com.project.group17.group.entity.GroupEntity;
import com.project.group17.group.entity.GroupPojo;
import com.project.group17.group.entity.UserPojo;
import com.project.group17.group.repository.GroupRepository;
import com.project.group17.match.service.MatchService;
import com.project.group17.prefValues.model.PrefValueSaveReq;
import com.project.group17.prefValues.service.PrefValuesService;
import com.project.group17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    PrefValuesService prefValuesService;

    @Autowired
    MatchService matchService;

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
    public List<Map<String, String>> getGroupUsers(Long groupID){
        List<GroupEntity> groupEntities = groupRepository.findByGroupId(groupID);
        List<User> groupUsers = new ArrayList<>();
        for (GroupEntity groupEntity: groupEntities){
            groupUsers.add(groupEntity.getUser());
        }
        return matchService.getAllUserInfoAndPreferences(groupUsers);
    }
    public List<GroupPojo> getAllGroups(User user) {

        List<GroupEntity> groupEntities = groupRepository.findAll();

        List<PrefValueSaveReq> prefValueSaveReqsCurrentUser = prefValuesService.getUserPrefValuesById(user.getId());

        long similarity = 0;

        HashMap<Long, List<UserPojo>> groupedUsers = new HashMap<>();

        for (GroupEntity groupEntity: groupEntities)
        {
            UserPojo userPojo = new UserPojo();
            userPojo.setUserID(groupEntity.getUser().getId());
            userPojo.setFirstName(groupEntity.getUser().getFirstname());
            userPojo.setLastName(groupEntity.getUser().getLastname());
            userPojo.setEmail(groupEntity.getUser().getEmail());
            userPojo.setAge(groupEntity.getUser().getAge());
            userPojo.setCity(groupEntity.getUser().getCity());
            userPojo.setProvince(groupEntity.getUser().getProvince());
            userPojo.setStreetAddress(groupEntity.getUser().getStreetAddress());
            userPojo.setProfilePicBase64(groupEntity.getUser().getProfilePicBase64());
            userPojo.setGender(groupEntity.getUser().getGender());
            userPojo.setPhoneNumber(groupEntity.getUser().getPhoneNumber());

            if(groupedUsers.containsKey(groupEntity.getGroupId()))
            {
                groupedUsers.get(groupEntity.getGroupId()).add(userPojo);
            }
            else
            {
                groupedUsers.put(groupEntity.getGroupId(), new ArrayList<>());
                groupedUsers.get(groupEntity.getGroupId()).add(userPojo);
            }

            List<PrefValueSaveReq> prefValueSaveReqs1;
            prefValueSaveReqs1 = prefValuesService.getUserPrefValuesById(groupEntity.getUser().getId());

            int count = 0;
            for(PrefValueSaveReq prefValueSaveReq: prefValueSaveReqs1)
            {
                if(prefValueSaveReq.getPrefOptionId() == prefValueSaveReqsCurrentUser.get(count).getPrefOptionId() ) {
                    similarity++;
                }
                count++;
            }

            userPojo.setSimilarity(similarity/23.0);

        }

        List<GroupPojo> groupPojo = new ArrayList<>();

        for (Map.Entry<Long, List<UserPojo>> groupedUser : groupedUsers.entrySet()) {
            List<UserPojo> userList = groupedUser.getValue();
            Long groupID = groupedUser.getKey();

            double totalSimilarity = 0.0;
            for (UserPojo userPojo : userList) {
                totalSimilarity += userPojo.getSimilarity();
            }

            double avgSimilarity = totalSimilarity / groupedUser.getValue().size();

            GroupPojo currentGroupPojo = new GroupPojo();
            currentGroupPojo.setGroupID(groupID);
            currentGroupPojo.setUsers(userList);
            currentGroupPojo.setAvgSimilarity(avgSimilarity);

            groupPojo.add(currentGroupPojo);
        }
        //System.out.println(groupPojo);

        return groupPojo;
    }
}