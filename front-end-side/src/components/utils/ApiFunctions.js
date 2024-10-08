//in this file, we define all the functions that we interact with our server side

import axios from "axios";

export const api = axios.create({
  baseURL: "/api",
});

export const getHeader = () => {
  const token = localStorage.getItem("token");
  return {
    Authorization: `Bearer ${token}`,
    "Content-Type": "application/json",
  };
};

/* This function adds a new room room to the database */
export async function addRoom(photo, roomType, roomPrice) {
	const formData = new FormData()
	formData.append("photo", photo)
	formData.append("roomType", roomType)
	formData.append("roomPrice", roomPrice)

	const response = await api.post("/rooms/add/new-room", formData,{
		headers: getHeader()
	})
  //testAddRoom();

	if (response.status === 201) {
		return true
	} else {
		return false
	}
}


//Test function to check if addRoom is working
async function testAddRoom() {
  // Mock data for the test
  const photo = new Blob(["test photo"], { type: "image/jpeg" }); // Creating a mock Blob for photo
  const roomType = "Deluxe";
  const roomPrice = "200";

  try {
    const result = await addRoom(photo, roomType, roomPrice);
    console.log("addRoom result:", result);

    if (result) {
      console.log("Room added successfully.");
    } else {
      console.log("Failed to add room.");
    }
  } catch (error) {
    console.error("Error occurred while adding room:", error.message);
  }
}

// Call the test function (Comment this out after testing)
//testAddRoom();



/* This function gets all room types from thee database */
export async function getRoomTypes() {
	try {
		const response = await api.get("/rooms/room/types")
		return response.data
	} catch (error) {
		throw new Error("Error fetching room types")
	}
}