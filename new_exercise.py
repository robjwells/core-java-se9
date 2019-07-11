#!/usr/bin/env python3
import pathlib
import sys

template = """\
class Ex{ex_string} {{
    public static void main(String[] args) {{

    }}
}}
"""

if __name__ == "__main__":
    exercise = sys.argv[1].replace(".", "_")
    ex_dir = pathlib.Path(__file__).resolve().parent.joinpath("exercises")
    ex_dir.joinpath(f"Ex{exercise}.java").write_text(
        template.format(ex_string=exercise)
    )
