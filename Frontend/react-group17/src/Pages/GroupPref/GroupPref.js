import React, { useState, useEffect } from "react";
import GroupPrefEntry from "../../components/GroupPrefEntry/GroupPrefEntry";
import { getGroupUserList } from "../../services/GroupService";


const GroupPref = () => {

    const [isLoading, setLoading] = useState(true);
    const [groupUserDetails, setGroupUserDetails] = useState();

    useEffect(() => {
        getGroupUserList
            .then(
                (response) => {
                    console.log(response);
                    setGroupUserDetails(response.data);
                    setLoading(false);
                }
            )
            .catch(
                err => console.log(err)
            )
    }, []);

    const users = [
        {
            "id": 4,
            "firstname": "Naveen",
            "lastname": "K"
        }
    ]

    const renderGroupPref = () =>{
        return(
            <div className="matchList">
            {groupUserDetails.map(user => (
                <GroupPrefEntry
                    user={user}
                    key={user.id}
                />
            ))}
        </div>
        
  )
}


    return(
        <div className="">
            {/* { isLoading ? null : renderGroupPref() }  */}
            {renderGroupPref()}
        </div>
    );
}

export default GroupPref;