import http from 'k6/http';

export const options = {
    vus: 100,
    iterations: 1000,
};

export default function () {
    http.get('http://localhost:8888/home/index?real=1&img=3');
}