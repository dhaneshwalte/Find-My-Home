import React, { useState, useEffect, onClick, setContent, content} from 'react';

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
  MDBProgress,
  MDBProgressBar,
  MDBIcon,
  MDBListGroup,
  MDBListGroupItem
} from 'mdb-react-ui-kit';
import { getUserDetails, saveUserDetails } from '../../services/UserProfilePageService';
import { Button, InputNumber } from 'antd';
import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom';


const UserDetails = () => {
    const [userDetails, setUserDetails] = useState([ null ]);
  
    useEffect(() => {
      getUserDetails()
        .then((response) => {
          console.log(response);
          setUserDetails(response.data);
      })
      .catch(err => console.log(err));
});

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
const [editUserDetails, setEditUserDetails] = useState(getUserDetails);

const handleEditedUserDetails = (e) => {
    setEditUserDetails(e.target.value);
  }

const editClick = () => {
  setEditFlag(true);
}

const saveClick = () => {
  /* save user deyails in the backend */
  saveUserDetails()
  setEditFlag(false);
}

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
                <p className="text-muted mb-4">{userDetails.firstname}</p>
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
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}
                    >{userDetails.firstname}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Last Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}
                    > {userDetails.lastname}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>User Name</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    > {userDetails.username}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr/>
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Age</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >{ userDetails.age}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Gender</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >{ userDetails.gender}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Email</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >{userDetails.email}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Phone</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onInput={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >{ userDetails.phoneNumber}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Street Address</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onClick={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >{userDetails.streetAddress}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>City</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText className="text-muted"
                              contentEditable={editFlag}
                              onClick={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
                    >{userDetails.city}</MDBCardText>
                  </MDBCol>
                </MDBRow>
                <hr />
                <MDBRow>
                  <MDBCol sm="3">
                    <MDBCardText>Province</MDBCardText>
                  </MDBCol>
                  <MDBCol sm="9">
                    <MDBCardText
                              className="text-muted" 
                              contentEditable={editFlag}
                              onClick={handleEditedUserDetails}
                              onBlur={saveUserDetails}
                              suppressContentEditableWarning={true}                    
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
                <MDBCardText  style={{"text-align" : "center"}}><span className="text-primary font-bold me-1">{userDetails.firstname} Preferences</span></MDBCardText>
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
   userDetails[0] === null ? null : renderprofilePage()
  }
  </div>
)
              
}


export default UserDetails;