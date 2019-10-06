set link=%*
youtube-dl -x --audio-format mp3 --audio-quality 0 "ytsearch1:%link%" -o "downloaded/%%(title)s.%%(ext)s"
