import axios from "axios";

const HOST_URL = 'localhost:8080'
export function POST_API(file) {
    console.log(`업로드 파일 : ${file}`)
    return
    axios({
        method: 'post',
        url: HOST_URL,
        data: {
            file
        }
      });
}

export async function GET_API() {
    try {
        fetch('./tmp.json')
        .then(res => console.log(res))
    } catch (error) {
        
    }

}