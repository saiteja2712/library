import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import Userproduct from "./Taskuserproduct";
import Categories from "./Categories";

function Taskuser() {
  const [token, setToken] = useState();
  const [cat, setCat] = useState([]);
  const [email, setEmail] = useState("");
  const location = useLocation();
  const [catClick, setCatClick] = useState(false);
  const [products, setProducts] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    if (!localStorage.getItem("token")) {
      navigate("/taskuser");
    } else {
      setToken(localStorage.getItem("token"));
    }
    if (location.state && location.state.email) {
      setEmail(location.state.email);
    }
  }, [location, navigate]);
  async function allCat() {
    try {
      const response = await fetch("http://localhost:8090/getallcategories");
      const data = await response.json();
      setCat(data);
      console.log(data);
    } catch (error) {
      console.error("Error fetching categories:", error);
    }
  }
  useEffect(() => {
    allCat();
  }, []);

  async function getCat(categoryname) {
    setCatClick(!catClick);
    const res = await fetch(
      `http://localhost:8090/auth/book/books/${categoryname}`
    );
    const data = await res.json();
    setProducts(data);
  }

  async function getProducts() {
    try {
      const res = await fetch("http://localhost:8090/auth/book/bookget");
      const data = await res.json();
      setProducts(data);
    } catch (error) {
      console.error("Error fetching products:", error);
    }
  }

  useEffect(() => {
    getProducts();
  }, []);

  const logout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  const navigateToAssigned = () => {
    navigate("/taskassigned", { state: { email } });
  };

  return (
    <div>
      <h2 className="whole">Library page</h2>
      <div className="containerpower">
        <div className="sidenav">
          <h2>Menu</h2>

          <button
            className="btn btn-info"
            onClick={navigateToAssigned}
            id="round"
          >
            AssignedBooks
          </button>

          <button className="logout" onClick={logout}>
            Logout
          </button>
        </div>

        <div className="main">
          <div className="product-list" id="userproduct">
            <div className="allact">
              {cat.map((category, index) => (
                <button
                  className="btn btn-info"
                  id="info"
                  key={index}
                  value={category.name}
                  onClick={(e) => getCat(e.target.value)}
                >
                  {category.name}
                </button>
              ))}
            </div>

            {products?.map((p) => (
              <Userproduct {...p} key={p.id} email={email} />
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default Taskuser;
