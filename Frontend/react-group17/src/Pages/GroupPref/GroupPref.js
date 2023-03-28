import React, { useState } from "react";
import GroupPrefEntry from "../../components/GroupPrefEntry/GroupPrefEntry";


const GroupPref = () => {

    const [isLoading, setLoading] = useState(true);
    const [groupUserDetails, setGroupUserDetails] = useState();

    useEffect(() => {
        getRoommateList()
            .then(
                (response) => {
                    response.data.sort((a,b) => b.SimilarityScore - a.SimilarityScore);
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