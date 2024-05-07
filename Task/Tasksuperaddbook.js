import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function Tasksuperaddbook() {
  let [token, settoken] = useState();
  let [cname, setcname] = useState("");
  const [formData, setFormData] = useState({
    titleofbook: "",
    author: "",
    publishyear: "",
    imageofbook: null,
  });
  let [errors, seterrors] = useState({
    error_first: "",
    error_second: "",
    error_third: "",
    error_fourth: "",
    error_last: "",
  });
  let navigate = useNavigate();

  useEffect(() => {
    const storedToken = localStorage.getItem("token");
    if (!storedToken) {
      navigate("/");
    } else {
      settoken(storedToken);
    }
  }, [navigate]);

  const handleChange = (e) => {
    if (e.target.name === "imageofbook") {
      setFormData({ ...formData, imageofbook: e.target.files[0] });
      seterrors({
        ...errors,
        error_last: "",
      });
    } else {
      const { name, value } = e.target;
      setFormData((prevData) => ({
        ...prevData,
        [name]: value,
      }));
      seterrors({
        ...errors,
        error_first: "",
        error_second: "",
        error_third: "",
        error_fourth: "",
        error_last: "",
      });
    }
  };

  async function handleSubmit(e) {
    e.preventDefault();
    if (
      formData.titleofbook &&
      formData.author &&
      formData.publishyear &&
      formData.imageofbook &&
      cname
    ) {
      let formDataToSend = new FormData();
      formDataToSend.append("titleofbook", formData.titleofbook);
      formDataToSend.append("author", formData.author);
      formDataToSend.append("publishyear", formData.publishyear);
      formDataToSend.append("imageofbook", formData.imageofbook);
      try {
        let response = await fetch(
          `http://localhost:8090/auth/book/upload/${cname}`,
          {
            method: "POST",
            headers: {
              Authorization: `Bearer ${localStorage.getItem("token")}`,
            },
            body: formDataToSend,
          }
        );
        if (response.ok) {
          window.alert("Successfully added");
          setFormData({
            titleofbook: "",
            author: "",
            publishyear: "",
            imageofbook: null,
          });
          setcname("");
        }
      } catch (error) {
        console.error("Error", error);
      }
    } else if (
      !formData.first &&
      formData.last &&
      !formData.third &&
      !formData.second &&
      !formData.fourth
    ) {
      seterrors({
        ...errors,
        error_first: "Title is mandatory",
        error_second: "Author is mandatory",
        error_third: "Publishyear is Mandatory",
        error_fourth: "Category is Mandatory",
      });
    } else if (
      !formData.first &&
      !formData.last &&
      !formData.third &&
      !formData.second &&
      !formData.fourth
    ) {
      seterrors({
        ...errors,
        error_first: "Title is mandatory",
        error_second: "Author is mandatory",
        error_third: "Publishyear is Mandatory",
        error_fourth: "Category is Mandatory",
        error_last: "Image is Mandatory",
      });
    }
  }

  return (
    <div className="containerbook">
      <h2>Add a New Book</h2>
      <form onSubmit={handleSubmit} className="book-form">
        <div className="form-group">
          <label htmlFor="titleofbook" className="textlabel">
            Title
          </label>
          <input
            type="text"
            id="titleofbook"
            name="titleofbook"
            value={formData.titleofbook}
            onChange={handleChange}
          />
        </div>
        {errors.error_first && (
          <div style={{ color: "red", paddingLeft: "148px" }}>
            {errors.error_first}
          </div>
        )}

        <div className="form-group">
          <label htmlFor="author" className="authorlabel">
            Author
          </label>
          <input
            type="text"
            id="author"
            name="author"
            value={formData.author}
            onChange={handleChange}
          />
        </div>
        {errors.error_second && (
          <div style={{ color: "red", paddingLeft: "148px" }}>
            {errors.error_second}
          </div>
        )}
        <div className="form-group">
          <label htmlFor="publishyear" className="publish">
            Published Year
          </label>
          <input
            type="number"
            id="publishyear"
            name="publishyear"
            value={formData.publishyear}
            onChange={handleChange}
          />
        </div>
        {errors.error_third && (
          <div style={{ color: "red", paddingLeft: "148px" }}>
            {errors.error_third}
          </div>
        )}
        <div className="form-group">
          <label htmlFor="cat" className="cat">
            Category
          </label>
          <input
            type="text"
            id="cat"
            name="cat"
            value={cname}
            onChange={(e) => {
              setcname(e.target.value);
            }}
          />
        </div>
        {errors.error_fourth && (
          <div style={{ color: "red", paddingLeft: "148px" }}>
            {errors.error_fourth}
          </div>
        )}
        <div className="form-group">
          <label htmlFor="imageofbook" className="imagelabel">
            Upload Image
          </label>
          <input
            type="file"
            id="imageofbook"
            name="imageofbook"
            onChange={handleChange}
            accept="image/*"
          />
        </div>
        {errors.error_last && (
          <div style={{ color: "red", paddingLeft: "148px" }}>
            {errors.error_last}
          </div>
        )}
        <button type="submit" className="bookadd">
          Submit
        </button>
        <br />
        <Link to="/tasksuper" className="btn btn-danger">
          Back
        </Link>
      </form>
    </div>
  );
}
export default Tasksuperaddbook;
