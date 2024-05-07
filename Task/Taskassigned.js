import React, { useEffect, useState } from "react";
import "./Task.css";
import Booksassigned from "./Booksassigned";
import { useLocation, useNavigate } from "react-router-dom";

function Taskassigned() {
  const [userassign, setassign] = useState();
  const [email, setemail] = useState("");
  const location = useLocation();
  const navigate = useNavigate();

  useEffect(() => {
    if (location.state && location.state.email) {
      setemail(location.state.email);
      get(location.state.email); // Call get function with email
    }
  }, [location]);

  async function get(email) {
    console.log(email);

    try {
      const token = localStorage.getItem("token");
      if (!token) {
        navigate("/taskuser");
        return;
      }
      let res = await fetch(
        `http://localhost:8090/auth/book/assigned/${email}`,
        {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
        }
      );
      if (res.ok) {
        let dial = await res.json();
        setassign(dial);
      }
      if (!res.ok) {
        console.error("Failed to fetch assigned books:", res.status);
      }
    } catch (error) {
      console.error("Error fetching assigned books:", error);
    }
  }

  return (
    <>
      <div className="product-list">
        {userassign?.map((p) => (
          <Booksassigned {...p} key={p.id} email={email}></Booksassigned>
        ))}
      </div>
    </>
  );
}

export default Taskassigned;
