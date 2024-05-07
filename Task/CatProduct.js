import React from "react";
function Catproduct() {
  return (
    <>
      <h1>Categories</h1>
    </>
  );
}
export default Catproduct();
// import React, { useEffect, useState } from "react";
// import "./Frontcss.css";
// import FrontHeader from "../Front/FrontHeader";
// import Gall from "../Front/FrontGall";
// import ImageUploader from "../Front/Frontupload";

// const SideNavbar = () => {
//   const [image, setimage] = useState([]);
//   const [showUploader, setShowUploader] = useState(false);
//   const [showGallery, setShowGallery] = useState(true);

//   const fetchImages = async () => {
//     try {
//       let calling = await fetch("http://localhost:8099/upload/all");
//       let dial = await calling.json();
//       setimage(dial);
//       console.log(dial);
//     } catch (error) {
//       console.error("Error fetching images:", error);
//     }
//   };

//   useEffect(() => {
//     if (showUploader || showGallery) {
//       fetchImages();
//     }
//   }, [showUploader, showGallery]);

//   return (
//     <div>
//       <div className="header">
//         <div className="dash">DashBoard</div>
//         <FrontHeader />
//       </div>
//       <div className="containerpower">
//         <div className="sidenav">
//           <div className="create">
//             <br />
//             <img
//               className="imgs"
//               src="https://demos.creative-tim.com/black-dashboard-react/static/media/react-logo.561f1671.png"
//               alt="react-logo"
//             />
//             <h6>CREATIVE TIM</h6>
//             <br />
//           </div>
//           <ul>
//             <li>
//               <a href="#dashboard">
//                 <i className="fa-solid fa-chart-pie" id="icon"></i> Dashboard
//               </a>
//             </li>
//             <li>
//               <a href="#Icons">
//                 <i className="fa-solid fa-atom" id="icon"></i>Icons
//               </a>
//             </li>
//             <li>
//               <a href="#map">
//                 <i className="fas fa-map" id="icon"></i> Map
//               </a>
//             </li>
//             <li>
//               <a href="#notifications">
//                 <i className="fa-regular fa-bell" id="icon"></i> Notifications
//               </a>
//             </li>
//             <li>
//               <a href="#userprofile">
//                 <i className="fa-regular fa-user" id="icon"></i> User Profile
//               </a>
//             </li>
//             <li>
//               <a href="#tablelist">
//                 <i className="fas fa-table" id="icon"></i> Table List
//               </a>
//             </li>
//             <li>
//               <a href="#typography">
//                 <i className="fa-solid fa-align-center" id="icon"></i>{" "}
//                 Typography
//               </a>
//             </li>
//             <li>
//               <a href="#rtlsupport">
//                 <i className="fa-solid fa-globe" id="icon"></i> RTL Support
//               </a>
//             </li>

//             <li>
//               <a href="#upgradetopro">
//                 <i class="fa-solid fa-rocket" id="icon"></i>Upgrade to Pro
//               </a>
//             </li>
//           </ul>
//         </div>
//         <div className="main">
//           <div className="list">
//             <div className="h67">
//               <button
//                 className="btn btn-primary"
//                 id="butn"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(true);
//                 }}
//               >
//                 Gallery
//               </button>
//               <button
//                 className="btn btn-info"
//                 id="butn"
//                 onClick={() => {
//                   setShowUploader(true);
//                   setShowGallery(false);
//                 }}
//               >
//                 Upload
//               </button>
//             </div>
//             <div className="Api-list">
//               {showUploader && <ImageUploader />}
//               {showGallery && image.map((p) => <Gall {...p} key={p.id} />)}
//               <br />
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };
// export default SideNavbar;

// import React, { useEffect, useState } from "react";
// import "./Frontcss.css";
// import FrontHeader from "../Front/FrontHeader";
// import Gall from "../Front/FrontGall";
// import ImageUploader from "../Front/Frontupload";
// import Medal from "./Frontpopup";

// const SideNavbar = () => {
//   const [image, setimage] = useState([]);
//   const [showUploader, setShowUploader] = useState(false);
//   const [showGallery, setShowGallery] = useState(true);
//   const [showUploadModal, setShowUploadModal] = useState(false);
//   const fetchImages = async () => {
//     try {
//       let calling = await fetch("http://localhost:8099/upload/all");
//       let dial = await calling.json();
//       setimage(dial);
//       console.log(dial);
//     } catch (error) {
//       console.error("Error fetching images:", error);
//     }
//   };

//   useEffect(() => {
//     if (showUploader || showGallery) {
//       fetchImages();
//     }
//   }, [showUploader, showGallery]);
//   const handleUploadButtonClick = () => {
//     setShowUploader(true);
//     setShowGallery(false);
//     setShowUploadModal(true);
//   };
//   const handleModalClose = () => {
//     setShowUploadModal(false);
//     setShowUploader(false);
//     setShowGallery(true);
//   };

//   return (
//     <div>
//       <div className="header">
//         <div className="dash">DashBoard</div>
//         <FrontHeader />
//       </div>
//       <div className="containerpower">
//         <div className="sidenav">
//           <div className="create">
//             <br />
//             <img
//               className="imgs"
//               src="https://demos.creative-tim.com/black-dashboard-react/static/media/react-logo.561f1671.png"
//               alt="react-logo"
//             />
//             <h6>CREATIVE TIM</h6>
//             <br />
//           </div>
//           <ul>
//             <li>
//               <a href="#dashboard">
//                 <i className="fa-solid fa-chart-pie" id="icon"></i> Dashboard
//               </a>
//             </li>
//             <li>
//               <a href="#Icons">
//                 <i className="fa-solid fa-atom" id="icon"></i>Icons
//               </a>
//             </li>
//             <li>
//               <a href="#map">
//                 <i className="fas fa-map" id="icon"></i> Map
//               </a>
//             </li>
//             <li>
//               <a href="#notifications">
//                 <i className="fa-regular fa-bell" id="icon"></i> Notifications
//               </a>
//             </li>
//             <li>
//               <a href="#userprofile">
//                 <i className="fa-regular fa-user" id="icon"></i> User Profile
//               </a>
//             </li>
//             <li>
//               <a href="#tablelist">
//                 <i className="fas fa-table" id="icon"></i> Table List
//               </a>
//             </li>
//             <li>
//               <a href="#typography">
//                 <i className="fa-solid fa-align-center" id="icon"></i>{" "}
//                 Typography
//               </a>
//             </li>
//             <li>
//               <a href="#rtlsupport">
//                 <i className="fa-solid fa-globe" id="icon"></i> RTL Support
//               </a>
//             </li>

//             <li>
//               <a href="#upgradetopro">
//                 <i class="fa-solid fa-rocket" id="icon"></i>Upgrade to Pro
//               </a>
//             </li>
//           </ul>
//         </div>
//         <div className="main">
//           <div className="list">
//             <div className="h67">
//               <button
//                 className="btn btn-primary"
//                 id="butn"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(true);
//                 }}
//               >
//                 Gallery
//               </button>
//               <button
//                 className="btn btn-info"
//                 id="butn"
//                 onClick={handleUploadButtonClick}
//                 // onClick={() => {
//                 //   setShowUploader(true);
//                 //   setShowGallery(false);
//                 // }}
//               >
//                 Upload
//               </button>
//             </div>
//             <div className="Api-list">
//               {showUploader && <ImageUploader />}
//               {showGallery && image.map((p) => <Gall {...p} key={p.id} />)}
//               <br />
//             </div>
//           </div>
//         </div>
//       </div>
//       {showUploadModal && (
//         <Medal onClose={handleModalClose}>
//           <ImageUploader />
//         </Medal>
//       )}
//     </div>
//   );
// };

// export default SideNavbar;

// import React, { useEffect, useState } from "react";
// import "./Frontcss.css";
// import FrontHeader from "../Front/FrontHeader";
// import Gall from "../Front/FrontGall";
// import ImageUploader from "../Front/Frontupload";
// import Medal from "../Front/Frontpopup";

// const SideNavbar = () => {
//   const [image, setimage] = useState([]);
//   const [showUploader, setShowUploader] = useState(false);
//   const [showGallery, setShowGallery] = useState(true);
//   const [showPopup, setShowPopup] = useState(false);

//   const fetchImages = async () => {
//     try {
//       let calling = await fetch("http://localhost:8099/upload/all");
//       let dial = await calling.json();
//       setimage(dial);
//     } catch (error) {
//       console.error("Error fetching images:", error);
//     }
//   };

//   useEffect(() => {
//     if (showUploader || showGallery) {
//       fetchImages();
//     }
//   }, [showUploader, showGallery]);

//   const handleUploadButtonClick = () => {
//     setShowUploader(true);
//     setShowGallery(false);
//     setShowPopup(true);
//   };

//   const handleModalClose = () => {
//     setShowPopup(false);
//   };

//   return (
//     <div>
//       <div className="header">
//         <div className="dash">DashBoard</div>
//         <FrontHeader />
//       </div>
//       <div className="containerpower">
//         {/* Sidebar code remains the same */}
//       </div>
//       <div className="main">
//         <div className="list">
//           <div className="h67">
//             <button
//               className="btn btn-primary"
//               id="butn"
//               onClick={() => {
//                 setShowUploader(false);
//                 setShowGallery(true);
//               }}
//             >
//               Gallery
//             </button>
//             <button
//               className="btn btn-info"
//               id="butn"
//               onClick={handleUploadButtonClick}
//             >
//               Upload
//             </button>
//           </div>
//           <div className="Api-list">
//             {/* Render ImageUploader if showUploader is true */}
//             {showUploader && <ImageUploader />}
//             {/* Render Gallery */}
//             {showGallery && image.map((p) => <Gall {...p} key={p.id} />)}
//           </div>
//           {/* Render Modal if showPopup is true */}
//           {showPopup && (
//             <Medal onClose={handleModalClose}>
//               <ImageUploader />
//             </Medal>
//           )}
//         </div>
//       </div>
//     </div>
//   );
// };

// export default SideNavbar;

// import React, { useEffect, useState } from "react";
// import "./Frontcss.css";
// import FrontHeader from "./FrontHeader";
// import Gall from "./FrontGall";
// import ImageUploader from "./Frontupload";

// const SideNavbar = () => {
//   const [image, setimage] = useState([]);
//   const [showUploader, setShowUploader] = useState(false);
//   const [showGallery, setShowGallery] = useState(false);
//   const [showImages, setShowImages] = useState(false);

//   // Function to fetch images
//   const fetchImages = async () => {
//     let calling = await fetch("http://localhost:8099/upload/all");
//     let dial = await calling.json();
//     setimage(dial);
//     setShowImages(true);
//   };

//   useEffect(() => {
//     if (showImages) {
//       fetchImages();
//     }
//   }, [showImages]);

//   return (
//     <div>
//       <div className="header">
//         <div className="dash">DashBoard</div>
//         <FrontHeader />
//       </div>
//       <div className="containerpower">
//         <div className="sidenav">
//           <div className="create">
//             <br />
//             <img
//               className="imgs"
//               src="https://demos.creative-tim.com/black-dashboard-react/static/media/react-logo.561f1671.png"
//               alt="react-logo"
//             />
//             <h6>CREATIVE TIM</h6>
//             <br />
//           </div>
//           <ul>
//             <li>
//               <a
//                 href="#dashboard"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(true);
//                   setShowImages(true);
//                 }}
//               >
//                 <i className="fa-solid fa-chart-pie" id="icon"></i> Dashboard
//               </a>
//             </li>
//             <li>
//               <a
//                 href="#icons"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(false);
//                   setShowImages(false);
//                 }}
//               >
//                 <i className="fa-solid fa-atom" id="icon"></i> Icons
//               </a>
//             </li>
//             <li>
//               <a
//                 href="#map"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(false);
//                   setShowImages(false);
//                 }}
//               >
//                 <i className="fas fa-map" id="icon"></i> Map
//               </a>
//             </li>
//             <li>
//               <a
//                 href="#notifications"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(false);
//                   setShowImages(false);
//                 }}
//               >
//                 <i className="fa-regular fa-bell" id="icon"></i> Notifications
//               </a>
//             </li>
//             <li>
//               <a
//                 href="#userprofile"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(false);
//                   setShowImages(false);
//                 }}
//               >
//                 <i className="fa-regular fa-user" id="icon"></i> User Profile
//               </a>
//             </li>
//             <li>
//               <a
//                 href="#tablelist"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(false);
//                   setShowImages(false);
//                 }}
//               >
//                 <i className="fas fa-table" id="icon"></i> Table List
//               </a>
//             </li>
//             <li>
//               <a
//                 href="#typography"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(false);
//                   setShowImages(false);
//                 }}
//               >
//                 <i className="fa-solid fa-align-center" id="icon"></i>{" "}
//                 Typography
//               </a>
//             </li>
//             <li>
//               <a
//                 href="#rtlsupport"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(false);
//                   setShowImages(false);
//                 }}
//               >
//                 <i className="fa-solid fa-globe" id="icon"></i> RTL Support
//               </a>
//             </li>
//             <li>
//               <a
//                 href="#upgradetopro"
//                 onClick={() => {
//                   setShowUploader(false);
//                   setShowGallery(false);
//                   setShowImages(false);
//                 }}
//               >
//                 <i className="fa-solid fa-rocket" id="icon"></i> Upgrade to Pro
//               </a>
//             </li>
//           </ul>
//         </div>
//         <div className="main">
//           <div className="list">
//             {showGallery && (
//               <div className="h67">
//                 <button
//                   className="btn btn-primary"
//                   id="butn"
//                   onClick={() => {
//                     setShowUploader(false);
//                     setShowGallery(true);
//                     setShowImages(true);
//                   }}
//                 >
//                   Gallery
//                 </button>
//                 <button
//                   className="btn btn-info"
//                   id="butn"
//                   onClick={() => {
//                     setShowUploader(true);
//                     setShowGallery(true); // Set Gallery to true
//                     setShowImages(false);
//                   }}
//                 >
//                   Upload
//                 </button>
//               </div>
//             )}
//             <div className="Api-list">
//               {showUploader && <ImageUploader />}
//               {showImages && image.map((p) => <Gall {...p} key={p.id} />)}
//               <br />
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default SideNavbar;

// clicking on dashboard only gallery upload button is appering
// import React, { useEffect, useState } from "react";
// import "./Frontcss.css";
// import FrontHeader from "./FrontHeader";
// import Gall from "./FrontGall";
// import ImageUploader from "./Frontupload";

// const SideNavbar = () => {
//   const [image, setimage] = useState([]);
//   const [showUploader, setShowUploader] = useState(false);
//   const [showGallery, setShowGallery] = useState(false);
//   const [showDashboard, setShowDashboard] = useState(false); // Initial state to hide Gallery and Upload buttons

//   // Function to fetch images
//   const fetchImages = async () => {
//     let calling = await fetch("http://localhost:8099/upload/all");
//     let dial = await calling.json();
//     setimage(dial);
//     console.log(dial);
//   };

//   useEffect(() => {
//     if (showDashboard) {
//       // Fetch images only when Dashboard is clicked
//       fetchImages();
//     }
//   }, [showDashboard]);

//   return (
//     <div>
//       <div className="header">
//         <div className="dash">DashBoard</div>
//         <FrontHeader />
//       </div>
//       <div className="containerpower">
//         <div className="sidenav">
//           <div className="create">
//             <br />
//             <img
//               className="imgs"
//               src="https://demos.creative-tim.com/black-dashboard-react/static/media/react-logo.561f1671.png"
//               alt="react-logo"
//             />
//             <h6>CREATIVE TIM</h6>
//             <br />
//           </div>
//           <ul>
//             <li>
//               <a href="#dashboard" onClick={() => setShowDashboard(true)}>
//                 {" "}
//                 {/* Set showDashboard state to true when Dashboard is clicked */}
//                 <i className="fa-solid fa-chart-pie" id="icon"></i> Dashboard
//               </a>
//             </li>
//             <li>
//               <a href="#Icons">
//                 <i className="fa-solid fa-atom" id="icon"></i>Icons
//               </a>
//             </li>
//             <li>
//               <a href="#map" onClick={() => setShowDashboard(false)}>
//                 {" "}
//                 {/* Set showDashboard state to false when Map is clicked */}
//                 <i className="fas fa-map" id="icon"></i> Map
//               </a>
//             </li>
//             <li>
//               <a href="#notifications">
//                 <i className="fa-regular fa-bell" id="icon"></i> Notifications
//               </a>
//             </li>
//             {/* Other sidebar options */}
//           </ul>
//         </div>
//         <div className="main">
//           <div className="list">
//             {showDashboard && ( // Render Gallery and Upload buttons and images only when Dashboard is clicked
//               <>
//                 <div className="h67">
//                   <button
//                     className="btn btn-primary"
//                     id="butn"
//                     onClick={() => {
//                       setShowUploader(false);
//                       setShowGallery(true);
//                     }}
//                   >
//                     Gallery
//                   </button>
//                   <button
//                     className="btn btn-info"
//                     id="butn"
//                     onClick={() => {
//                       setShowUploader(true);
//                       setShowGallery(false);
//                     }}
//                   >
//                     Upload
//                   </button>
//                 </div>
//                 <div className="Api-list">
//                   {showUploader && <ImageUploader />}
//                   {showGallery && image.map((p) => <Gall {...p} key={p.id} />)}
//                   <br />
//                 </div>
//               </>
//             )}
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default SideNavbar;
