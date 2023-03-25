import  axios from 'axios';
import React, {useEffect,useState} from "react";
import { useNavigate } from "react-router-dom";
import { showListing } from "../../services/ListingsService";
import './style.css'

function ListingDetails() {
    const [listing, setListing] = useState([]);
    const [isDisabled, setIsDisabled] = useState(false);


    const fetchListings = async () => {
        const result = await axios.get("http://localhost:8080/api/v1/getAll");
        setListing(result.data);
      };

        useEffect(() => {
         fetchListings();
    },[])

    let navigate = useNavigate(); 
  const routeChange = () =>{ 
    let path = `Images`; 
    navigate(path);
  }

    function handleClick(e) 
    { 
      e.preventDefault();

      console.log("clicked")
      setIsDisabled(true);
    }
    const [imageUrl, setImageUrl] = useState(null);

  


    return (
        <div className="container">
          <div className="py-4">
            <table className="table border shadow">
              <thead>
                <tr>
                  <th scope="col">ListingNo.</th>
                  <th scope="col">Type</th>
                  <th scope="col">Address</th>
                  <th scope="col">Utilities</th>
                  <th scope="col">Rent</th>
                  <th scope="col">OtherDetails</th>
                  <th scope="col">Image1</th>
                  <th scope="col">Image1</th>
                </tr>
              </thead>
              
              <tbody>
                {listing.map((listi, index) => (
                  <tr>
                    {/* <th scope="row" key={index}>
                      {index - 1}
                    </th> */}
                    <td>{listi.listingId}</td>
                    <td>{listi.type}</td>
                    <td>{listi.address}</td>
                    <td>{listi.utilities}</td>
                    <td>{listi.rent}</td>
                    <td>{listi.details}</td>
                    <td><img src={listi.profilePicBase64} alt="image1" style={{width: "150px", height: "150px"} }/>
                    </td>
                    <td><img src={listi.secondProfilePicBase64} alt="image2" style={{width: "150px", height: "150px"} }/></td>
                    <td>
                    <button onClick={() => handleClick(listi.listingId)}>more</button>
                    </td>
                    </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      );
}
export default ListingDetails;