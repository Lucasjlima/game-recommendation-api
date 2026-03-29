CREATE TABLE games (
    game_id UUID NOT NULL DEFAULT gen_random_uuid(),
    external_name VARCHAR(255) NOT NULL UNIQUE,
    rating DOUBLE PRECISION NOT NULL,
    ratings_count BIGINT,
    background_image VARCHAR(1024),
    released VARCHAR(50),
    PRIMARY KEY (game_id)
);

CREATE TABLE user_games (
    user_game_id UUID NOT NULL DEFAULT gen_random_uuid(),
    user_id BIGINT NOT NULL,
    game_id UUID NOT NULL,
    saved_at TIMESTAMP NOT NULL DEFAULT now(),
    status VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_game_id),
    CONSTRAINT fk_user_games_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT fk_user_games_game FOREIGN KEY (game_id) REFERENCES games (game_id)
);
