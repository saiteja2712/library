import React, { useEffect, useState } from "react";

function Categories() {
  const [cat, setCat] = useState([]);

  useEffect(() => {
    allCat();
  }, []);

  async function allCat() {
    try {
      const response = await fetch("https://localhost:8090/getallcategories");
      const data = await response.json();
      setCat(data);
      console.log(data);
    } catch (error) {
      console.error("Error fetching categories:", error);
    }
  }

  return (
    <div className="categories">
      {cat.map((category, index) => (
        <button className="btn btn-danger" key={index}>
          {category.name}
        </button>
      ))}
    </div>
  );
}

export default Categories;

// clicking on dashboard only gallery upload button is appering  Front end gallery upload task images are not coming only clicking on gallery images are appearing
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

// clicking on dash board then only gallery and upload button visible and also images are coming on clicking dashboard
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

// import React, { useState } from "react";
// import Modal from "./Frontmodel";

// const ImageUploader = () => {
//   const [files, setFiles] = useState([]);
//   const [uploadResponse, setUploadResponse] = useState("");
//   const [isUploading, setIsUploading] = useState(false);

//   const handleDragOver = (e) => {
//     e.preventDefault();
//   };

//   const handleDrop = (e) => {
//     e.preventDefault();
//     const droppedFiles = Array.from(e.dataTransfer.files);
//     if (files.length + droppedFiles.length <= 2) {
//       setFiles((prevFiles) => [...prevFiles, ...droppedFiles]);
//     } else {
//       alert("You can upload a maximum of two images.");
//     }
//   };

//   const handleFileInputChange = (e) => {
//     const selectedFiles = Array.from(e.target.files);
//     if (files.length + selectedFiles.length <= 2) {
//       setFiles((prevFiles) => [...prevFiles, ...selectedFiles]);
//     } else {
//       alert("You can upload a maximum of two images.");
//     }
//   };

//   const handleUpload = async () => {
//     if (files.length === 0) {
//       alert("Please select at least one image to upload.");
//       return;
//     }
//     setIsUploading(true);
//     const formData = new FormData();
//     files.forEach((file) => formData.append("files", file));
//     try {
//       const response = await fetch("http://localhost:8099/upload/uploads", {
//         method: "POST",
//         body: formData,
//       });
//       const data = await response.text();
//       setUploadResponse(data);
//       setFiles([]);
//     } catch (error) {
//       setUploadResponse("Failed to upload images.");
//     } finally {
//       setIsUploading(false);
//     }
//   };

//   return (
//     <div className="image-uploader">
//       <h2>Upload images</h2>
//       <p>Start by adding images for processing.</p>
//       <div
//         onDragOver={handleDragOver}
//         onDrop={handleDrop}
//         className="drop-area"
//       >
//         <p>
//           Drag & Drop your images here or{" "}
//           <label htmlFor="file-input" className="browse">
//             browse files
//           </label>
//           <input
//             type="file"
//             id="file-input"
//             accept="image/*"
//             onChange={handleFileInputChange}
//             style={{ display: "none" }}
//             multiple
//           />
//         </p>
//       </div>
//       {files.length === 0 && (
//         <div>
//           <p>No images uploaded</p>
//           <p>
//             You do not have any files loaded yet. Start now by dragging to the
//             box above or selecting images using the button above.
//           </p>
//         </div>
//       )}
//       {files.length > 0 && (
//         <>
//           <h3 id="h3">Uploaded Files</h3>
//           <ul className="uploaded-files">
//             {files.map((file, index) => (
//               <li key={index}>
//                 <i class="fa-solid fa-image" id="imgicon"></i>
//                 {file.name}
//                 <span> - We are processing your image...</span>
//               </li>
//             ))}
//           </ul>
//         </>
//       )}
//       <button
//         className="btn btn-primary"
//         id="upbtn"
//         onClick={handleUpload}
//         disabled={files.length === 0 || isUploading}
//       >
//         {isUploading ? "Uploading..." : "Upload"}
//       </button>
//       {/* {uploadResponse && <p>{uploadResponse}</p>} */}
//     </div>
//   );
// };

// export default ImageUploader;

// import React, { useState } from "react";
// import Modal from "./Frontmodel";

// const ImageUploader = () => {
//   const [files, setFiles] = useState([]);
//   const [uploadResponse, setUploadResponse] = useState("");
//   const [isUploading, setIsUploading] = useState(false);
//   const [showPopup, setShowPopup] = useState(false);

//   const handleDragOver = (e) => {
//     e.preventDefault();
//   };

//   const handleDrop = (e) => {
//     e.preventDefault();
//     const droppedFiles = Array.from(e.dataTransfer.files);
//     if (files.length + droppedFiles.length <= 2) {
//       setFiles((prevFiles) => [...prevFiles, ...droppedFiles]);
//     } else {
//       alert("You can upload a maximum of two images.");
//     }
//   };

//   const handleFileInputChange = (e) => {
//     const selectedFiles = Array.from(e.target.files);
//     if (files.length + selectedFiles.length <= 2) {
//       setFiles((prevFiles) => [...prevFiles, ...selectedFiles]);
//     } else {
//       alert("You can upload a maximum of two images.");
//     }
//   };

//   const handleUpload = async () => {
//     if (files.length === 0) {
//       alert("Please select at least one image to upload.");
//       return;
//     }
//     setIsUploading(true);
//     const formData = new FormData();
//     files.forEach((file) => formData.append("files", file));
//     try {
//       const response = await fetch("http://localhost:8099/upload/uploads", {
//         method: "POST",
//         body: formData,
//       });
//       const data = await response.text();
//       setUploadResponse(data);
//       setFiles([]);
//       setShowPopup(true); // Show the popup after successful upload
//     } catch (error) {
//       setUploadResponse("Failed to upload images.");
//     } finally {
//       setIsUploading(false);
//     }
//   };

//   return (
//     <div className="image-uploader">
//       <h2>Upload images</h2>
//       <p>Start by adding images for processing.</p>
//       <div
//         onDragOver={handleDragOver}
//         onDrop={handleDrop}
//         className="drop-area"
//       >
//         <p>
//           Drag & Drop your images here or{" "}
//           <label htmlFor="file-input" className="browse">
//             browse files
//           </label>
//           <input
//             type="file"
//             id="file-input"
//             accept="image/*"
//             onChange={handleFileInputChange}
//             style={{ display: "none" }}
//             multiple
//           />
//           <br></br>
//           <i class="fa-solid fa-cloud-arrow-up" id="cloud"></i>
//         </p>
//       </div>
//       {files.length === 0 && (
//         <div>
//           <p>No images uploaded</p>
//           <p>
//             You do not have any files loaded yet. Start now by dragging to the
//             box above or selecting images using the button above.
//           </p>
//         </div>
//       )}
//       {files.length > 0 && (
//         <>
//           <h3 id="h3">Uploaded Files</h3>
//           <ul className="uploaded-files">
//             {files.map((file, index) => (
//               <li key={index}>
//                 <i class="fa-solid fa-image" id="imgicon"></i>
//                 {file.name}
//                 <span> - We are processing your image...</span>
//               </li>
//             ))}
//           </ul>
//         </>
//       )}
//       <button
//         className="btn btn-primary"
//         id="upbtn"
//         onClick={handleUpload}
//         disabled={files.length === 0 || isUploading}
//       >
//         {isUploading ? "Uploading..." : "Upload"}
//       </button>
//       {showPopup && (
//         <Modal
//           content="Image added successfully."
//           onClose={() => setShowPopup(false)}
//         />
//       )}
//     </div>
//   );
// };

// export default ImageUploader;
