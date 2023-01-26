INSERT INTO public.navigation
    (text, icon)
VALUES
    ('home', 'fa-solid fa-house'),
    ('about', 'fa-solid fa-address-card'),
    ('experience', 'fa-solid fa-code'),
    ('project', 'fa-solid fa-diagram-project');

INSERT INTO public.home
    (intro, name, bio)
VALUES
    ('Hi, I am', 'Ryan Aristosa',  'Jr. Software Engineer at Cognizant Softvision');

INSERT INTO public.about
    (title, name, username)
VALUES
    ('About Me', 'Ryan Aristosa', '@ryan-aristosa');

INSERT INTO public.about_content
    (content, about_id)
VALUES
    ('I am Ryan Aristosa, but you can call me R. I am a Jr. Software Engineer at Cognizant Softvision, with some knowledge in building and connecting frontend to backend using services and API.', '1'),
    ('I am a graduate of Bachelor of Science in Information Technology in STI College Pasay-EDSA as Magna Cum Laude. Me and my team are also awarded with Best Capstone Project Awardee.', '1'),
    ('My hobbies are playing games, and watching anime and tv series. I am also a casual fan of K-pop, due to its songs and dance choreography. On some free time, I try to upskill myself through reading and trying different things.', '1'),
    ('Lastly, I can say that I am perseverant, optimistic, responsible, and well-organized.', '1');
