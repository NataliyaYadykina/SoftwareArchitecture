const route = (event) => {
    event = event || window.event;
    event.preventDefault();
    window.history.pushState({}, "", event.target.href);
    handleLocation();
}

const routes = {
    404: "./pages/404.html",
    '/seminars/sem7/SPA/': './pages/home.html',
    '/seminars/sem7/SPA/home': './pages/home.html',
    '/seminars/sem7/SPA/about': './pages/about.html',
    '/seminars/sem7/SPA/contact': './pages/contact.html'
};

const handleLocation = async () => {
    const path = window.location.pathname;
    console.log(path);
    const route = routes[path] || routes[404];
    const html = await fetch(route).then((data) => data.text());
    document.getElementById("main-page").innerHTML = html;
};

window.onpopstate = handleLocation;
window.route = route;

handleLocation();
