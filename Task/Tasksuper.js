import React, { useEffect, useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import Productbook from "./TaskProductbook";
import { getProducts } from "./ProductApi";
function Tasksuper({ superid }) {
  let [products, updateproducts] = useState([]);
  let [token, settoken] = useState();
  let navigate = useNavigate();
  useEffect(() => {
    if (!localStorage.getItem("token")) {
      navigate("/");
    } else {
      settoken(localStorage.getItem("token"));
      console.log(localStorage.getItem("token"));
      fetchProducts();
    }
  }, []);

  async function fetchProducts() {
    try {
      const productList = await getProducts();
      updateproducts(productList);
      // console.log(productList);
    } catch (error) {
      console.error("Error fetching products:", error);
    }
  }

  let logout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };
  return (
    <>
      <div>
        <h2 className="whole">Library page</h2>
        <div className="containerpower">
          <div className="sidenav">
            <h2>Menu</h2>
            <Link to="/tasksuperadduser" className="btn btn-success" id="round">
              Add User
            </Link>

            <Link
              to={`/tasksupergetuser/${superid}`}
              className="btn btn-dark"
              id="roun"
            >
              Fetch users
            </Link>

            <Link to="/tasksuperaddbook" className="btn btn-info" id="roun">
              Add Book
            </Link>

            <Link
              to="/tasksuperaddcategory"
              className="btn btn-warning"
              id="roun"
            >
              AddCategory
            </Link>

            <button className="logout" onClick={logout} id="roun">
              Logout
            </button>
          </div>
          <div className="main">
            <div className="product-list">
              {/* <h1> Library page</h1> */}
              {products.map((p) => (
                <Productbook {...p} key={p.id}></Productbook>
              ))}
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
export default Tasksuper;
