import React from "react";
import "./Task.css";

function Userproduct({
  id,
  titleofbook,
  author,
  publishyear,
  imageofbook,
  email,
}) {
  async function assign() {
    console.log(id);
    console.log(email);
    console.log(localStorage.getItem("token"));
    let response = await fetch(
      `http://localhost:8090/auth/book/bookemail/${email}/${id}`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
        body: JSON.stringify(),
      }
    );
    if (response.ok) {
      window.alert("book assigned successfully");
    } else {
      window.alert("book already assigned ");
    }
  }

  return (
    <div className="card">
      <img
        src={`data:image/jpeg;base64,${imageofbook}`}
        alt={titleofbook}
        width="100px"
        height="fit-content"
      />
      <b>{titleofbook}</b>
      <div className="author">
        <h5>{author}</h5>
        <h6>{publishyear}</h6>
        <div className="assign">
          <button className="btn btn-info" onClick={assign}>
            Assign
          </button>
        </div>
      </div>
    </div>
  );
}

export default Userproduct;
