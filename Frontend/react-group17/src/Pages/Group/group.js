import React, { useEffect } from "react";
import { useState } from "react";
import { getGroupsList } from "../../services/GroupService";
// import { useState } from "react";
// import { getRoommateList } from "../../services/MatchService";
import GroupMatchEntry from "../../components/GroupMatchEntry/GroupMatchEntry";
import './group.css'

const GroupMatch = () => {

    const [isLoading, setLoading] = useState(true);
    const [groups, setGroups] = useState([]);

    useEffect(() => {
        getGroupsList()
            .then(
                (response) => {
                    response.data.sort((a,b) => b.SimilarityScore - a.SimilarityScore);
                    console.log(response);
                    setGroups(response.data);
                    setLoading(false);
                }
            )
            .catch(
                err => console.log(err)
            )
    }, []);


    const deleteGroup = groupID => {
        const filtered = groups.filter(group => group.groupID !== groupID);
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
            { isLoading ? null : renderGroupMatchList() }
            {/* {renderGroupMatchList()} */}
        </div>
    );
}

export default GroupMatch;
