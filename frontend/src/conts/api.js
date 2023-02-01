import axios from "axios";

const HOST_URL = 'http://localhost:8082'
export function POST_API(file) {
    console.log(`업로드 파일 : ${file}`)
    axios({
        method: 'post',
        url: `${HOST_URL}/save`,
        params: {
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