import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function Booksassigned({
  id,
  titleofbook,
  author,
  publishyear,
  imageofbook,
  email,
}) {
  const [assignedEmail, setAssignedEmail] = useState(email);
  const navigate = useNavigate();

  useEffect(() => {
    setAssignedEmail(email);
  }, [email]);

  async function release() {
    console.log(assignedEmail);
    let res = await fetch(
      `http://localhost:8090/auth/book/releasedemail/${assignedEmail}/${id}`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
        body: JSON.stringify(),
      }
    );

    if (res.ok) {
      window.alert("book released successfully");
      // You might want to refresh the list of assigned books after releasing
      // Implement the logic here if needed
    } else {
      window.alert("first assign the book");
    }
  }

  return (
    <div className="card">
      <img
        src={`data:image/jpeg;base64,${imageofbook}`}
        width="100px"
        height="fit-content"
        alt={titleofbook}
      />
      <p>{id}</p>
      <b>{titleofbook}</b>

      <br></br>
      <div className="author">
        <h5 margin-top="30px">{author}</h5>
        <h6>{publishyear}</h6>
        <div className="assign">
          <div className="btn btn-secondary" onClick={release}>
            Release
          </div>
        </div>
      </div>
    </div>
  );
}

export default Booksassigned;

// import React, { useEffect, useState } from "react";
// import "./Task.css";
// import { useLocation, useNavigate } from "react-router-dom";

// function Booksassigned({
//   id,
//   titleofbook,
//   author,
//   publishyear,
//   imageofbook,
//   email,
// }) {
//   const location = useLocation();
//   // const [email, setemail] = useState("");
//   // useEffect(() => {
//   //   if (location.state && location.state.email) {
//   //     setemail(location.state.email);
//   //     get(location.state.email); // Call get function with email
//   //   }
//   // }, [location]);
//   let navigate = useNavigate();
//   useEffect(() => {
//     get();
//   }, []);
//   async function get(email) {
//     console.log(email);

//     try {
//       const token = localStorage.getItem("token");
//       if (!token) {
//         navigate("/taskuser");
//         return;
//       }
//       let res = await fetch(
//         `http://localhost:8090/auth/book/assigned/${email}`,
//         {
//           method: "GET",
//           headers: {
//             "Content-Type": "application/json",
//             Authorization: `Bearer ${token}`,
//           },
//         }
//       );
//       if (res.ok) {
//         let dial = await res.json();
//         // setassign(dial);
//       } else {
//         console.error("Failed to fetch assigned books:", res.status);
//       }
//     } catch (error) {
//       console.error("Error fetching assigned books:", error);
//     }
//   }
//   async function release() {
//     console.log(email);
//     let res = await fetch(
//       `http://localhost:8090/auth/book/releasedemail/${email}/${id}`,
//       {
//         method: "POST",
//         headers: {
//           "Content-Type": "application/json",
//           Authorization: `Bearer ${localStorage.getItem("token")}`,
//         },
//         body: JSON.stringify(),
//       }
//     );

//     if (res.ok) {
//       window.alert("book released successfully");
//       get();
//     } else {
//       window.alert("first assign the book");
//     }
//   }

//   return (
//     <>
//       <div className="card">
//         <img
//           src={`data:image/jpeg;base64,${imageofbook}`}
//           width="100px"
//           height="fit-content"
//         ></img>
//         <p>{id}</p>
//         <b>{titleofbook}</b>

//         <br></br>
//         <div className="author">
//           <h5 margin-top="30px">{author}</h5>
//           <h6>{publishyear}</h6>
//           <div className="assign">
//             <div className="btn btn-secondary" onClick={release}>
//               Release
//             </div>
//           </div>
//         </div>
//       </div>
//     </>
//   );
// }
// export default Booksassigned;
