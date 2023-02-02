import axios from "axios";
import data from './tmp.json'

const HOST_URL = 'http://localhost:8082'
export async function POST_API(file) {
    let formData = new FormData(); 
    formData.append("file", file)
    let response = await axios.post(`${HOST_URL}/save`, formData, {
        headers : {'Content-Type' : 'multipart/formData'}
    })
}


export async function GET_API() {
    let response
    try {
       response = data.DATA
    } catch (error) {
        
    }
    return response
}