import React, { useState } from "react";


const GroupPref = () => {

    const [isLoading, setLoading] = useState(true);



    const renderGroupPref = () =>{
        return(

            <div>
                <p>HI</p>
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