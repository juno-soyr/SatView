{
  description = "SatView";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs?ref=nixos-25.05";
    nix-metals.url = "github:what-the-functor/nix-metals";
  };
  outputs =
    { nixpkgs }:
    let
      pkgs = import nixpkgs { system = "x86_64-linux"; };
    in
    {
      devShells.x86_64-linux.default = pkgs.mkShell {
        buildInputs = [
          pkgs.scala
          pkgs.jdk
          pkgs.gradle
        ];
      };
    };
}
