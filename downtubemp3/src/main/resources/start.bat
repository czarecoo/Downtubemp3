set link=%1
youtube-dl -x --audio-format mp3 --audio-quality 0 "%link%" -o "%%(title)s.%%(ext)s"
