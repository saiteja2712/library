import React, { useState } from "react";
import "./Task.css";
import { useNavigate } from "react-router-dom";

function Forgotpassword() {
  let [email, setemail] = useState("");
  let navigate = useNavigate();
  let [errors, seterrors] = useState({
    error_first: "",
  });
  async function Send(e) {
    e.preventDefault();
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!email) {
      seterrors({
        ...errors,
        error_first: "email is mandatory",
      });
    } else if (!emailPattern.test(email)) {
      seterrors({
        ...errors,
        error_first: "Invalid email address",
      });
      return;
    } else {
      console.log("email:" + email);
      setemail("");
    }
  }
  let back = () => {
    navigate("/");
  };
  return (
    <>
      <form onSubmit={Send}>
        <div className="forgot">
          <div className="col">
            <div className="rowone">
              <div>
                <h5>Forgotpassword page</h5>
                <div>
                  <input
                    type="email"
                    className="inputbox"
                    placeholder="Enter your email"
                    value={email}
                    onChange={(e) => {
                      setemail(e.target.value);
                    }}
                  />
                  {errors.error_first && (
                    <div style={{ color: "red", paddingRight: "120px" }}>
                      {errors.error_first}
                    </div>
                  )}
                </div>
                <br></br>
                <br></br>
                <div>
                  <input
                    type="submit"
                    className="btn btn-primary"
                    id="forgot"
                  ></input>
                  <button className="btn btn-danger" id="danger" onClick={back}>
                    Back
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </form>
    </>
  );
}
export default Forgotpassword;
