import React, { useEffect } from "react";
import { useState, setLoading } from "react";
import { getGroupsList } from "../../services/GroupService";
import GroupMatchEntry from "../../components/GroupMatchEntry/GroupMatchEntry";
import './group.css'

const GroupMatch = () => {

    // const [isLoading, setLoading] = useState(true);
    const [groups, setGroups] = useState([]);
    // const groups = [
    //     {
    //         "groupID": 1,
    //         "avgSimilarity": 0.21739130434782608,
    //         "users": [
    //         {
    //             "userID": 25,
    //             "firstName": "Dan",
    //             "lastName": "w",
    //             "similarity": 0.08695652173913043
    //         },
    //         {
    //             "UserID": 23,
    //             "firstName": "Bil",
    //             "lastName": "b",
    //             "similarity": 0.34782608695652173
    //         }   
    //         ]
    //     },
    //     {
    //         "groupID": 2,
    //         "avgsimilarity" : 0.5652173913043479,
    //         "users": [
    //             {
    //                 "userID": 37,
    //                 "firstName": "Naveen",
    //                 "lastName": "K",
    //                 "similarity": 0.5217391304347826
    //             },
    //             {
    //                 "userID": 32,
    //                 "firstName": "NIV",
    //                 "lastName": "KI",
    //                 "similarity": 0.5217391304347826
    //             }
    //         ]
    //     }
    // ]

    useEffect(() => {
        // console.log(getGroupsList());
        getGroupsList()
            .then(
                (response) => {
                    response.data.sort((a,b) => b.SimilarityScore - a.SimilarityScore);
                    console.log(response);
                    setGroups(response.data);
                    // setLoading(false);
                }
            )
            .catch(
                err => console.log(err)
            )
    }, []);


    const deleteGroup = id => {
        const filtered = groups.filter(group => group.id !== id);
        console.log(groups.group.id);
        console.log(id);
        setGroups(filtered);
    };

    const renderGroupMatchList = () => {
        console.log(groups);
        return (
            <div className="matchList">
                {groups.map(user => (
                    <GroupMatchEntry
                        group= { user }
                        onDelete={deleteGroup}
                    />
                ))}
            </div>
        )
    }

    return (
        <div className="">
            {/* { isLoading ? null : renderGroupMatchList() } */}
            {renderGroupMatchList()}
        </div>
    );
}

export default GroupMatch;