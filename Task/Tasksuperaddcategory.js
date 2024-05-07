import React, { useEffect, useState } from "react";
import "./Task.css";
import { useNavigate } from "react-router-dom";

function Tasksuperaddcategory() {
  let [form, setForm] = useState({
    name: "",
  });
  let [errors, setErrors] = useState({
    error_first: "",
  });
  let navigate = useNavigate();
  let [token, settoken] = useState();

  async function Register(e) {
    e.preventDefault();
    console.log("Submitting form with name:", form.name);
    if (!form.name) {
      setErrors({
        ...errors,
        error_first: "Name is mandatory",
      });
      return;
    }

    try {
      let response = await fetch("http://localhost:8090/categories", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
        body: JSON.stringify(form),
      });

      if (response.ok) {
        console.log("Registration success");
        window.alert("Successfully added");
        setForm({
          name: "",
        });
        // navigate("/tasksuper");
      } else {
        window.alert("Failed to add category category already exists");
        console.error("Registration failed:", response.statusText);
      }
    } catch (error) {
      console.error("An error occurred:", error);
      window.alert("An error occurred while adding category");
    }
  }

  useEffect(() => {
    // Redirect if token exists, otherwise go to login
    if (!localStorage.getItem("token")) {
      navigate("/");
    } else {
      settoken(localStorage.getItem("token"));
      console.log(localStorage.getItem("token"));
    }
  }, []);

  let Change = (key, value) => {
    setForm({
      ...form,
      [key]: value,
    });
    setErrors({
      ...errors,
      error_first: "",
    });
  };

  let back = () => {
    localStorage.removeItem("tokens");
    navigate("/tasksuper");
  };

  return (
    <>
      <form onSubmit={Register}>
        <div className="imagestart">
          <div className="col">
            <div className="rowone">
              <div>
                <br />
                <h5>Add Category</h5>
                <div>
                  <input
                    className="inputbox"
                    type="text"
                    placeholder="Enter Your Categoryname"
                    id="first"
                    value={form.name}
                    onChange={(e) => {
                      Change("name", e.target.value);
                    }}
                  />
                </div>
                {errors.error_first && (
                  <div style={{ color: "red", paddingRight: "100px" }}>
                    {errors.error_first}
                  </div>
                )}
                <br />
                <div>
                  <button type="submit" className="btn btn-primary" id="btns">
                    Add Category
                  </button>
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

export default Tasksuperaddcategory;
