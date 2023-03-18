import React, { useState, useEffect, setRedirect, onClick, setContent, content} from 'react';

import {
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBCard,
  MDBCardText,
  MDBCardBody,
  MDBCardImage,
  MDBBtn,
  MDBBreadcrumb,
  MDBBreadcrumbItem,
  MDBIcon,
  MDBListGroup,
  MDBListGroupItem
} from 'mdb-react-ui-kit';
import { getUserDetails, saveUserDetails } from '../../services/UserProfilePageService';
<<<<<<< Updated upstream
import { Button, InputNumber } from 'antd';
import { BrowserRouter, redirect, Route, Routes, useNavigate } from 'react-router-dom';
=======
import { Button, Input, InputNumber } from 'antd';
import { BrowserRouter, redirect, Route, Routes, useNavigate } from 'react-router-dom';
import "./profile.css";
>>>>>>> Stashed changes


const UserDetails = () => {
    const [userDetails, setUserDetails] = useState([ null ]);
  
    useEffect(() => {
      getUserDetails()
        .then((response) => {
          console.log(response);
          setUserDetails(response.data);
      })
      .catch(err => console.log(err));
}, []);

const navigate = useNavigate();
const roommatePrefButton = () =>{
    navigate('/user-preference');
}

const propertyPrefButton = () =>{
  navigate('/user-preference');
}

const userDetailsPrefButton = () =>{
  navigate('/user-preference');
}

const housesPrefButton = () =>{
  navigate('/user-preference');
}

const likesPrefButton = () =>{
  navigate('/user-preference');
}

const groupsPrefButton = () =>{
  navigate('/user-preference');
}

const fullPrefListButton = () =>{
  navigate('/user-preference');
}

const [editFlag, setEditFlag] = useState(false);
<<<<<<< Updated upstream
const [editUserDetails, setEditUserDetails] = useState(getUserDetails);

const handleEditedUserDetails = (e) => {
  console.log("handle function called");
  }
=======
const [editUserDetails, setEditUserDetails] = useState({});


const handleEditedUserDetails = (e) => {
  console.log("handle function called");
}
>>>>>>> Stashed changes

const editClick = () => {
  setEditFlag(true);
}

const saveClick = () => {
  setEditUserDetails ({
    "firstname" : document.getElementById("firstname").textContent,
    "lastname" : document.getElementById("lastname").textContent,
    "age" : document.getElementById("age").textContent,
    "gender" : document.getElementById("gender").textContent,
    "email" : document.getElementById("email").textContent,
    "phoneNumber" : document.getElementById("phone").textContent,
    "streetAddress" : document.getElementById("streetAddress").textContent,
    "city" : document.getElementById("city").textContent,
    "province" : document.getElementById("province").textContent
  }
  )
<<<<<<< Updated upstream
  saveUserDetails(editUserDetails)
}
=======
}
useEffect( ()=>{
  console.log(editUserDetails);
  if(Object.keys(editUserDetails).length !== 0){
    saveUserDetails(editUserDetails);
    console.log(editUserDetails);
  }
} ,[editUserDetails]);
>>>>>>> Stashed changes

const cancelClick = () => {
  setEditFlag(false);
}


const renderprofilePage = () => {
  return (
    <section style={{ backgroundColor: '#eee' }}>
      <MDBContainer className="py-5">
        <MDBRow>
          <MDBCol>
            <MDBBreadcrumb className="bg-light rounded-3 p-3 mb-4">
              <MDBBreadcrumbItem>
                <p>ProfilePage</p>
              </MDBBreadcrumbItem>
            </MDBBreadcrumb>
          </MDBCol>
        </MDBRow>

        <MDBRow>
          <MDBCol lg="4">
            <MDBCard className="mb-4">
              <MDBCardBody className="text-center">
                <MDBCardImage
                  src = {userDetails.profilePicBase64}
                  alt="avatar"
                  className="rounded-circle"
                  style={{ width: '150px' }}
                  fluid />
                <p className="text-muted mb-4">{userDetails.firstName}</p>
                <p className="text-muted mb-4">{userDetails.city}, {userDetails.province}</p>
                <div className="d-flex justify-content-center mb-2">
                  <Button >edit</Button>
                </div>
              </MDBCardBody>
            </MDBCard>

            <MDBCard className="mb-4">
              <MDBCardBody className="text-center">
                <p className="text-muted mb-4">{userDetails.username} Preferences</p>
                <div className="d-flex justify-content-center mb-2">
                  <Button onClick={groupsPrefButton}
                  >show Preferences</Button>
                </div>
              </MDBCardBody>
            </MDBCard>

            <MDBCard className="mb-4">
              <MDBCardBody className="text-center">
                <p className="text-muted mb-4">{userDetails.username} Groups</p>
                <div className="d-flex justify-content-center mb-2">
                  <Button onClick={groupsPrefButton}
                  >Show Groups</Button>
                </div>
              </MDBCardBody>

            </MDBCard>
            <MDBCard className="mb-4">
              <MDBCardBody className="text-center">
                <p className="text-muted mb-4">{userDetails.username} Likes</p>
                <div className="d-flex justify-content-center mb-2">
                  <Button onClick={likesPrefButton}
                  >Show Likes</Button>
                </div>
              </MDBCardBody>
            </MDBCard>

            <MDBCard className="mb-4">
              <MDBCardBody className="text-center">
                <p className="text-muted mb-4">{userDetails.username} Houses </p>
                <div className="d-flex justify-content-center mb-2">
                  <Button onClick={housesPrefButton}
                  >Show Houses</Button>
                </div>
              </MDBCardBody>
            </MDBCard>
          </MDBCol>

          <MDBCol lg="8">
            <MDBCard className="mb-2">
              <MDBCardBody>
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>First Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id='firstname'
                              className="text-muted"
                              contentEditable={editFlag}
<<<<<<< Updated upstream
                              // onInput={handleEditedUserDetails}
=======
>>>>>>> Stashed changes
                              onChange={handleEditedUserDetails}
                              suppressContentEditableWarning={true}
                    >{userDetails.firstName}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Last Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id='lastname'
<<<<<<< Updated upstream
                              className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              // onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}
                    > {userDetails.lastName}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                {/* <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>User Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id=
                              className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              onChange={saveUserDetails}
                              suppressContentEditableWarning={true}
                    > {userDetails.email}</MDBCardText>
                  </MDBCol>
                </MDBRow> */}
=======
                                className="text-muted"
                                contentEditable={editFlag}
                                onChange={handleEditedUserDetails}
                                suppressContentEditableWarning={true}
                    > {userDetails.lastName}</MDBCardText>
                  </MDBCol>
                </MDBRow>
>>>>>>> Stashed changes
                <hr/>
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Age</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id = "age"
<<<<<<< Updated upstream
                              className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              // onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >22</MDBCardText>
=======
                                className="text-muted"
                                contentEditable={editFlag}
                                onChange={handleEditedUserDetails}
                                suppressContentEditableWarning={true}                
                    >{userDetails.age}</MDBCardText>
>>>>>>> Stashed changes
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Gender</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id="gender"
<<<<<<< Updated upstream
                              className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              // onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
=======
                                className="text-muted"
                                contentEditable={editFlag}
                                onChange={handleEditedUserDetails}
                                suppressContentEditableWarning={true}                      
>>>>>>> Stashed changes
                    >{ userDetails.Gender}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Email</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id= "email"
<<<<<<< Updated upstream
                              className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              // onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
=======
                                className="text-muted"
                                contentEditable={editFlag}
                                onChange={handleEditedUserDetails}
                                suppressContentEditableWarning={true}                     
>>>>>>> Stashed changes
                    >{userDetails.email}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Phone</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id = "phone"
<<<<<<< Updated upstream
                              className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              // onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >9029941286</MDBCardText>
=======
                                className="text-muted"
                                contentEditable={editFlag}
                                onChange={handleEditedUserDetails}
                                suppressContentEditableWarning={true}                   
                    >{userDetails.phoneNumber}</MDBCardText>
>>>>>>> Stashed changes
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Street Address</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id = "streetAddress"
<<<<<<< Updated upstream
                              className="text-muted"
                              contentEditable={editFlag}
                              onClick={handleEditedUserDetails}
                              // onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >1920, Gaston Road</MDBCardText>
=======
                                className="text-muted"
                                contentEditable={editFlag}
                                onChange={handleEditedUserDetails}
                                suppressContentEditableWarning={true}                      
                    >{userDetails.streetAddress}</MDBCardText>
>>>>>>> Stashed changes
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>City</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id = "city"
<<<<<<< Updated upstream
                              className="text-muted"
                              contentEditable={editFlag}
                              onClick={handleEditedUserDetails}
                              // onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
=======
                                className="text-muted"
                                contentEditable={editFlag}
                                onChange={handleEditedUserDetails}
                                suppressContentEditableWarning={true}                    
>>>>>>> Stashed changes
                    >{userDetails.city}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Province</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText id = "province"
<<<<<<< Updated upstream
                              className="text-muted" 
                              contentEditable={editFlag}
                              onClick={handleEditedUserDetails}
                              // onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
=======
                                  className="text-muted"
                                  contentEditable={editFlag}
                                  onChange={handleEditedUserDetails}
                                  suppressContentEditableWarning={true}                    
>>>>>>> Stashed changes
                    > {userDetails.province}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr/>
                { editFlag ? (
                  <div>
                    <Button color='primary' onClick={saveClick}>Save</Button>
                    <Button color='secondary' onClick={cancelClick}>Cancel</Button>
                  </div>
                ) : (
                  <Button onClick={editClick}>Edit</Button>
                )}
              </MDBCardBody>
            </MDBCard>

            
            <MDBCol sm="14">
            <MDBCard className="mb-2">
            <MDBCardBody>
                <MDBCardText  style={{"text-align" : "center"}}><span className="text-primary font-bold me-1">{userDetails.firstName} Preferences</span></MDBCardText>
                <MDBCardText className="text-muted"></MDBCardText>
            </MDBCardBody>
            </MDBCard>
            </MDBCol>

            <MDBRow>
              <MDBCol md="6">
                <MDBCard className="mb-4 mb-md-0">
                  <MDBCardBody>
                    <MDBCardText style={{"text-align" : "center"}} className="mb-4"><span className="text-primary font-bold me-1">Property</span> Preferences</MDBCardText>
                    
                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Property Type: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>appartment</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Location: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>location</MDBCardText>
                      </MDBCol>
                    </MDBRow>


                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Fursnished: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>Semi</MDBCardText>
                      </MDBCol>
                    </MDBRow>


                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Lease Length: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>1 year</MDBCardText>
                      </MDBCol>
                    </MDBRow>


                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Move in Date: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>ASAP</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Budget: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>2000$</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>BedRooms: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>2</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Bathrooms: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>1</MDBCardText>
                      </MDBCol>
                    </MDBRow>
                    <hr/>
                    <Button>edit</Button>
                  </MDBCardBody>
                </MDBCard>
              </MDBCol>

              <MDBCol md="6">
                <MDBCard className="mb-4 mb-md-0">
                  <MDBCardBody>
                    <MDBCardText style={{"text-align" : "center"}} className="mb-4"><span className="text-primary font-bold me-1">Roommate</span> Preferences</MDBCardText>
                    
                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Gender: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>Male</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Pets: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>No</MDBCardText>
                      </MDBCol>
                    </MDBRow>


                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Meal: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>Non Veg</MDBCardText>
                      </MDBCol>
                    </MDBRow>


                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Rent Budget: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>1000$</MDBCardText>
                      </MDBCol>
                    </MDBRow>


                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Max Roommates: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>4</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Drinking: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>No</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Smoker: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>No</MDBCardText>
                      </MDBCol>
                    </MDBRow>

                    <hr />
                    <MDBRow>
                      <MDBCol sm="5">
                        <MDBCardText className="mb-1" style={{ fontSize: '.85rem' }}>Occupation: </MDBCardText>
                      </MDBCol>
                      <MDBCol sm="6">
                        <MDBCardText className="text-muted" style={{ fontSize: '.85rem' }}>Student</MDBCardText>
                      </MDBCol>
                    </MDBRow>
                    <hr/>
                    <Button onClick={roommatePrefButton}>edit</Button>
                  </MDBCardBody>
                </MDBCard>
              </MDBCol>
            </MDBRow>

          </MDBCol>
        </MDBRow>
      </MDBContainer>
    </section>
  );
}

return(
  <div>
  {
   userDetails[0] === "null" ? null : renderprofilePage()
  }
  </div>
)
              
}


export default UserDetails;