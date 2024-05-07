// ProductAPI.js
export async function getProducts() {
  let res = await fetch("http://localhost:8090/auth/book/bookget");
  let list = await res.json();
  return list;
}
