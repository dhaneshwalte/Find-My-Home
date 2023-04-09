import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getLikedListings } from "../../services/ListingsService";
import { Button } from 'antd';

function LikedListings() {
  const [listing, setListing] = useState([]);
  let navigate = useNavigate();

  const fetchListings = () => {
    getLikedListings()
      .then((response) => {
        console.log(response.data);
        let listings = response.data;
        listings = listings.filter(n => n);
        console.log(listings);
        setListing(listings);
      })
      .catch(err => console.log(err))
  };

  useEffect(() => {
    fetchListings();
  }, [])

  function handleClick(e, listingId) {
    navigate("/show-liked-listing", {
      state: {
        listing: listing[listingId-1] //listingId indexes in the databases start from 1
      }
    })
  }

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">ListingNo.</th>
              <th scope="col">Type</th>
              <th scope="col">Address</th>
              <th scope="col">Rent</th>
            </tr>
          </thead>

          <tbody>
            {listing.map((listi, index) => (
              <tr key={listi.listingId}>
                <td>{listi.listingId}</td>
                <td>{listi.type}</td>
                <td>{listi.address}</td>
                <td>{listi.rent}</td>
                <td>
                  <Button onClick={() => handleClick(listi.listingId, listi.listingId)}>Show details</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
export default LikedListings;