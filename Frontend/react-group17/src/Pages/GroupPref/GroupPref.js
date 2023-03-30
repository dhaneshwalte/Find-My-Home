import React, { useState, useEffect } from "react";
import { useSearchParams } from "react-router-dom";
import GroupPrefEntry from "../../components/GroupPrefEntry/GroupPrefEntry";
import { getGroupUserList } from "../../services/GroupService";

const GroupPref = () => {

    const [isLoading, setLoading] = useState(true);
    const [groupUserDetails, setGroupUserDetails] = useState();
    const [searchParams] = useSearchParams();
    const code = searchParams.get('groupID'); 
    //console.log(code);

    useEffect(() => {
        const data = {
            "groupId": code
        }
        getGroupUserList(data)
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
            // eslint-disable-next-line
    }, [code]);


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
            { isLoading ? null : renderGroupPref() } 
            {/* {renderGroupPref()} */}
        </div>
    );
}

export default GroupPref;