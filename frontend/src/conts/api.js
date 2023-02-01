import axios from "axios";

const HOST_URL = 'http://localhost:8082'
export async function POST_API(file) {
    let formData = new FormData(); 
    formData.append("file", file)
    console.log(file)
    await axios.post(`${HOST_URL}/save`, formData, {
        headers : {'Content-Type' : 'multipart/formData'}
    })
}


export async function GET_API() {
    try {
        fetch('./tmp.json')
        .then(res => console.log(res))
    } catch (error) {
        
    }

}