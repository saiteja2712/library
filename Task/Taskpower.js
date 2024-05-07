import React, { useEffect, useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import Productbook from "./TaskProductbook";
import { getProducts } from "./ProductApi";
function Taskpower() {
  let [token, settoken] = useState("");
  let [products, updateproducts] = useState([""]);
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
      console.log(productList);
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
            <Link to="/taskpowerget" className="btn btn-primary" id="round">
              Fetch Users
            </Link>

            <Link to="/taskpowergetadmin" className="btn btn-success" id="roun">
              FetchAdmins
            </Link>

            <Link to="/taskpoweradduser" className="btn btn-info" id="roun">
              AddEndUser
            </Link>

            <Link to="/taskpoweraddsuper" className="btn btn-dark" id="roun">
              AddAdmin
            </Link>

            <button className="logout" onClick={logout} id="roun">
              Logout
            </button>
          </div>
          <div className="main">
            <div className="product-list">
              {/* <h1>Library Page</h1> */}
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

export default Taskpower;
