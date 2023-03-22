import  axios from 'axios';
import React, {useEffect,useState} from "react";
import { showListing } from "../../services/ListingsService";
function ListingDetails() {
    const [listing, setListing] = useState([]);


    const fetchListings = async () => {
        const result = await axios.get("http://localhost:8080/api/getAll");
        setListing(result.data);
      };

        useEffect(() => {
         fetchListings();
    },[])


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
                    <button> like </button>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      );
}
export default ListingDetails;